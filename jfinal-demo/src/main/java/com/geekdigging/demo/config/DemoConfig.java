package com.geekdigging.demo.config;

import com.geekdigging.demo.controller.UserController;
import com.geekdigging.demo.interceptor.ActionInterceptor;
import com.geekdigging.demo.interceptor.AuthInterceptor;
import com.geekdigging.demo.interceptor.ServiceInterceptor;
import com.geekdigging.demo.model.User;
import com.jfinal.config.*;
import com.jfinal.json.MixedJsonFactory;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: weishiyao
 * @Date: 2020/6/21
 * @Time: 0:32
 * @email: inwsy@hotmail.com
 * Description:
 */
public class DemoConfig extends JFinalConfig {

    static Prop p;

    /**
     * PropKit.useFirstFound(...) 使用参数中从左到右最先被找到的配置文件
     * 从左到右依次去找配置，找到则立即加载并立即返回，后续配置将被忽略
     */
    static void loadConfig() {
        if (p == null) {
            p = PropKit.useFirstFound("demo-config-pro.txt", "demo-config-dev.txt");
        }
    }

    public static void main(String[] args) {
        UndertowServer.start(DemoConfig.class);
    }

    @Override
    public void configConstant(Constants me) {

        loadConfig();

        // 配置开发模式，true 值为开发模式
        me.setDevMode(true);

        // 配置 aop 代理使用 cglib，否则将使用 jfinal 默认的动态编译代理方案
        me.setToCglibProxyFactory();

        // 配置依赖注入
        me.setInjectDependency(true);

        // 配置依赖注入时，是否对被注入类的超类进行注入
        me.setInjectSuperClass(false);

        // 配置为 slf4j 日志系统，否则默认将使用 log4j
        // 还可以通过 me.setLogFactory(...) 配置为自行扩展的日志系统实现类
        me.setToSlf4jLogFactory();

        // 设置 Json 转换工厂实现类，更多说明见第 12 章
        me.setJsonFactory(new MixedJsonFactory());

        // 配置视图类型，默认使用 jfinal enjoy 模板引擎
        me.setViewType(ViewType.JFINAL_TEMPLATE);

        // 配置 404、500 页面
        me.setError404View("/common/404.html");
        me.setError500View("/common/500.html");

        // 配置 encoding，默认为 UTF8
        me.setEncoding("UTF8");

        // 配置 json 转换 Date 类型时使用的 data parttern
        me.setJsonDatePattern("yyyy-MM-dd HH:mm");

        // 配置是否拒绝访问 JSP，是指直接访问 .jsp 文件，与 renderJsp(xxx.jsp) 无关
        me.setDenyAccessJsp(true);

        // 配置上传文件最大数据量，默认 10M
        me.setMaxPostSize(10 * 1024 * 1024);

        // 配置验证码缓存 cache，配置成集中共享缓存可以支持分布式与集群
        // me.setCaptchaCache(...);

        // 配置 urlPara 参数分隔字符，默认为 "-"
        me.setUrlParaSeparator("-");
    }

    @Override
    public void configRoute(Routes me) {
        me.add("/user", UserController.class);
    }

    @Override
    public void configEngine(Engine engine) {

    }

    @Override
    public void configPlugin(Plugins me) {
        DruidPlugin dp = new DruidPlugin(p.get("jdbcUrl"), p.get("user"), p.get("password").trim());
        me.add(dp);

        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        arp.addMapping("user", User.class);
        me.add(arp);
    }

    public static DruidPlugin createDruidPlugin() {
        loadConfig();

        return new DruidPlugin(p.get("jdbcUrl"), p.get("user"), p.get("password").trim());
    }

    @Override
    public void configInterceptor(Interceptors me) {

        me.add(new AuthInterceptor());

        me.addGlobalActionInterceptor(new ActionInterceptor());

        me.addGlobalServiceInterceptor(new ServiceInterceptor());
    }

    @Override
    public void configHandler(Handlers handlers) {

    }
}
