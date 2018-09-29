import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.eclipse.jetty.util.resource.Resource;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.EnumSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Server jettyServer = new Server(8080);
        jettyServer.setHandler(getHandlersConfig());

        try {
            jettyServer.start();
            //if(debug) jettyServer.dumpStdErr();
            jettyServer.join();
        } catch (Exception e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            jettyServer.destroy();
        }
    }

    public static HandlerList getHandlersConfig() {
        ServletContextHandler servletsHandler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        servletsHandler.setContextPath("/");
        servletsHandler.addServlet(new ServletHolder(new ServletContainer(getResourceConfig())), "/rest/*");

        FilterHolder holder = new FilterHolder(new CrossOriginFilter());
        holder.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,POST,HEAD,OPTIONS");
        servletsHandler.addFilter(holder, "/rest/*", EnumSet.of(DispatcherType.REQUEST));

        ResourceHandler resourceHandler = getResourceHandler();
        resourceHandler.setWelcomeFiles(new String[]{"login.html"});
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, "uuuuu");
        resourceHandler.setBaseResource(Resource.newClassPathResource("/webapp"));

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resourceHandler, servletsHandler});
        return handlers;
    }

    private static ResourceHandler getResourceHandler(){
        return new ResourceHandler(){
            @Override
            public void handle(String target, Request baseRequest, HttpServletRequest request,
                               HttpServletResponse response) throws IOException, ServletException {
                if(target.equals("/user.html")
                        || target.equals("/achievements.html")
                        || target.equals("/gameplay.html")) {
                    Boolean flag = true;

                    if (flag) {
                        //response.sendRedirect("/login.html");
                    }
                }
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, "iiiii");
                super.handle(target, baseRequest, request, response);
            }
        };
    }

    private static ResourceConfig getResourceConfig() {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, "lllllll");
        return new ResourceConfig() {{
            packages("game");
            register(new AbstractBinder() {
                @Override
                protected void configure () {
//                    bindAsContract(RoomDaoImpl.class).to(RoomDao.class);
//                    bindAsContract(RoomServiceImpl.class).to(RoomService.class);
//                    bindAsContract(RoomControllerImpl.class).to(RoomController.class);
                }
            });
        }};
    }
}
