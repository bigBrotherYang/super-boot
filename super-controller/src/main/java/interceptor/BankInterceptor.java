package interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BankInterceptor extends HandlerInterceptorAdapter {
    /**
     * //在控制器方法调用前执行
     * //返回值为是否中断，true,表示继续执行（下一个拦截器或处理器）
     * //false则会中断后续的所有操作，所以我们需要使用response来响应请求
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return super.preHandle(request, response, handler);
    }

    /**
     * //在控制器方法调用后，解析视图前调用，我们可以对视图和模型做进一步渲染或修改
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * //整个请求完成，即视图渲染结束后调用，这个时候可以做些资源清理工作，或日志记录等
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    /**
     * 相对于HandlerInterceptor，HandlerInterceptorAdapter多了一个实现方法afterConcurrentHandlingStarted()，它来自HandlerInterceptorAdapter的直接实现类AsyncHandlerInterceptor,AsyncHandlerInterceptor接口直接继承了HandlerInterceptor，并新添了afterConcurrentHandlingStarted()方法用于处理异步请求，当Controller中有异步请求方法的时候会触发该方法时，异步请求先支持preHandle、然后执行afterConcurrentHandlingStarted。异步线程完成之后执行preHandle、postHandle、afterCompletion。
     *
     * @param request
     * @param response
     * @param handler
     * @throws Exception
     */
    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
