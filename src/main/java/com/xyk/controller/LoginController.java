package com.xyk.controller;

import com.xyk.bean.Result;
import com.xyk.dao.PlatformConfigDaoImpl;
import com.xyk.dao.StatisticsUserDao;
import com.xyk.dao.UserDao;
import com.xyk.entity.PageRes;
import com.xyk.entity.PlatformConfig;
import com.xyk.entity.StatisticsUser;
import com.xyk.entity.User;
import com.xyk.enums.ResultEnum;
import com.xyk.service.StatisticsUserService;
import com.xyk.service.UserService;
import com.xyk.util.JsonUtil;
import com.xyk.util.ResultUtil;
import com.xyk.util.StringUtil;
import com.xyk.util.memory.MemoryData;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController extends BaseController{
    @Autowired
    UserService userService;
    @Autowired
    StatisticsUserService statisticsUserService;
    @Autowired
    PlatformConfigDaoImpl platformConfigDaoImpl;
    @Autowired
    StatisticsUserDao statisticsUserDao;
    @Autowired
    UserDao userDao;
    private Logger logger = Logger.getLogger(LoginController.class);

    /**
     * 跳转到填写联系方式页面
     * @return
     */
//    @RequestMapping(value = "/addStatisticsUser")
//    public String addStatisticsUser( ){
//        return "/addStatisticsList";
//    }

    /**
     * 根据id跳转到指定页面
     * @param p
     * @param model
     * @return
     */
    @RequestMapping(value = "/getPlatformById",method = RequestMethod.GET)
    public String getPlatformById(@RequestParam("p") Integer p,Model model){
        model.addAttribute("pid",p);
        return "/addStatisticsList";
    }

    /**
     * 添加联系人信息
     *
     * @return
     */
    @RequestMapping(value = "/addStaUser",method = RequestMethod.POST)
    @ResponseBody
    public Result addStaUser(@RequestParam("person") String person,@RequestParam("iphone") String iphone,@RequestParam("address") String address,@RequestParam("pid") Integer pid){
        StatisticsUser staUser = new StatisticsUser();
        staUser.setIphone(iphone);
        staUser.setPerson(person);
        staUser.setAddress(address);
        staUser.setPfId(pid);
        statisticsUserService.addStatisticsUser(staUser);
        PlatformConfig platform = platformConfigDaoImpl.findPlatformById(pid);
        if(platform==null){
            //跳转到错误页面
            return ResultUtil.error(ResultEnum.UNKNOW_ERROR.getCode(),"系统错误");
        }else{
            String weibist =  platform.getWebsite();
            return ResultUtil.success(weibist);
        }

    }
    //主页
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(ModelMap model){
        String welcomePage = "/admin/welcome";
        model.addAttribute("welcomePage",welcomePage);
        return  "/admin/main";
    }
    // get请求，访问添加用户 页面
    @RequestMapping(value = "/admin/welcome", method = RequestMethod.GET)
    public String welcome() {
        return "admin/welcome";
    }
    //跳转到登录页面
    @RequestMapping("/")
    public String login(){
        return "login";
    }
    //用户登出
    @RequestMapping("/loginOut")
    public String loginOut(HttpSession httpSession){
        //清除session
        if(super.getNowUser()==null){
            return "redirect:/";
        }
        logger.info(super.getNowUser().getUsername()+"登出了系统");
        httpSession.invalidate();
        return  "redirect:/";
    }
    @RequestMapping("/userlogin")
    public String userlogin(@RequestParam("username") String username,@RequestParam("password") String password, Model model, HttpSession httpSession){
        logger.info("用户尝试登录.....");
        //判断用户名和密码不能为空
        if(StringUtil.isNull(username)||StringUtil.isNull(password)){
            model.addAttribute("errorMsg","用户名或密码不能为空");
            model.addAttribute("username",username);
        }
        User user = userService.login(username, password);
        if(user != null){
            logger.info(username+"登录成功");
            String userId = user.getId().toString();
            List<PageRes> resList =installMenu(user.getResList());
            httpSession.setAttribute("user",user);
            String sessionId = httpSession.getId();
            /**********以下为单点登录************/
            String sessionID = httpSession.getId();
            if (!MemoryData.getSessionIDMap().containsKey(userId)) {
                //不存在，首次登陆，放入Map
                MemoryData.getSessionIDMap().put(userId, sessionID);
            }else if(MemoryData.getSessionIDMap().containsKey(userId)&&!StringUtils.equals(sessionID, MemoryData.getSessionIDMap().get(userId))){
                MemoryData.getSessionIDMap().remove(userId);
                MemoryData.getSessionIDMap().put(userId, sessionID);
            }

            return "redirect:/index";
        }else{
            logger.info(username+"登录失败【用户名或密码错误】");
            model.addAttribute("errorMsg","用户名或密码错误");
            model.addAttribute("username",username);
            return login();
        }
    }
      /**
     * 组装用户的菜单列表
     * @param resList
     */
    private List<PageRes> installMenu(List<PageRes> resList){
        List<PageRes> menulist = new ArrayList<PageRes>();//最后的结果
        // 先找到所有的一级菜单
        for (int i = 0; i < resList.size(); i++) {
            // 一级菜单parentId = -1 || isnull
            PageRes res = resList.get(i);
            if(res.getShowMenu()==1){
                continue;
            }
            //资源若有父节点则用户没有其父节点的权限则资源会看不到
            if (res.getParentResId()==null||res.getParentResId()==-1) {
                menulist.add(res);
            }
        }
        // 为一级菜单设置子菜单，getChild是递归调用的
        for (PageRes res : menulist) {
            int pkId = res.getId();
            res.setChildList(getChild(pkId, resList));
        }
        return menulist;
    }

    /**
     * 递归查询子菜单
     * @param id
     * @param rootMenu
     * @return
     */
    private List<PageRes> getChild(int id,List<PageRes> rootMenu){
        List<PageRes> childList = new ArrayList<>();
        for (PageRes menu: rootMenu) {
            if(menu.getShowMenu()==1){
                continue;
            }
            //遍历所有节点
            if (menu.getParentResId()!=null&&menu.getParentResId()==id) {
                childList.add(menu);
            }
        }
         // 把子菜单的子菜单再循环一遍
        for (PageRes res : childList) {
            // 该资源为功能菜单时继续查找他的子资源
            if (res.getResType()==0) {
                // 递归
                res.setChildList(getChild(res.getId(), rootMenu));
            }
        }
        // 递归退出条件
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }

    /**
     * 跳转到修改密码页面
     * @return
     */
    @RequestMapping(value = "admin/user/updatePwdPage",method = RequestMethod.GET)
    public String updatePwdPage(){
        return  "admin/user/updatePwd";
    }

    /**
     * 修改密码
     * @param password
     * @param new_password
     * @param new_password2
     * @return
     */
    @RequestMapping(value = "admin/user/updatePassword",method = RequestMethod.POST)
    @ResponseBody
    public Result updatePwdByUser(String password,String new_password,String new_password2){
        if(StringUtil.isNull(password)){
            return ResultUtil.error(ResultEnum.PARAM_ERROR.getCode(),"请输入旧密码");
        }
        if(StringUtil.isNull(new_password)){
            return ResultUtil.error(ResultEnum.PARAM_ERROR.getCode(),"请输入新密码");
        }
        if(!new_password.equals(new_password2)){
            return ResultUtil.error(ResultEnum.PARAM_ERROR.getCode(),"2次输入的新密码不相同");
        }
        password = StringUtil.EncoderByMd5(password);  //加密老密码
        User nowUser = super.getNowUser();
        User newUser = userDao.findUserByUsernameAndPwd(nowUser.getUsername(),password);
        if(newUser == null){
            return ResultUtil.error(ResultEnum.PARAM_ERROR.getCode(),"亲，旧密码输入错了哦");
        }
        userDao.updatePassword(StringUtil.EncoderByMd5(new_password),nowUser.getId());
        return ResultUtil.success();
    }
}
