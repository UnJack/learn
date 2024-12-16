//package org.learn.tech.io.net;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONException;
//import com.alibaba.fastjson.JSONObject;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.conn.ConnectTimeoutException;
//import org.apache.http.conn.scheme.PlainSocketFactory;
//import org.apache.http.conn.scheme.Scheme;
//import org.apache.http.conn.scheme.SchemeRegistry;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
//import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
//import org.apache.http.params.BasicHttpParams;
//import org.apache.http.params.HttpConnectionParams;
//import org.apache.http.params.HttpParams;
//import org.apache.http.util.EntityUtils;
//import org.springframework.stereotype.Service;
//
//import java.net.SocketTimeoutException;
//
//@Service("remitHttpClient")
//public class RemitHttpClient {
////    private static final Logger logger = Logger.getLogger(RemitHttpClient.class);
//
//    public static final int HTTP_OK = 200;
//    // 最大连接数
//    public final static int MAX_TOTAL_CONNECTIONS = 1000;
//    // 每个路由最大连接数
//    public final static int MAX_ROUTE_CONNECTIONS = 50;
//    // 默认的http 通信接口
//    public final static int DEFAULT_HTTP_PORT = 80;
//    // 默认的https 通信接口
//    public final static int DEFAULT_HTTPS_PORT = 443;
//
//    private ThreadSafeClientConnManager connectionManager;
//    private HttpParams httpParam;
//    //连接超时时间
//    private int connect_timeout;
//    //数据等待时间
//    private int reade_timeout;
//    //请求地址
//    private String url;
//    //字符编码
//    private String encode;
//    private String cookie;
//
//    public int getConnect_timeout() {
//        return connect_timeout;
//    }
//
//    public void setConnect_timeout(int connect_timeout) {
//        this.connect_timeout = connect_timeout;
//    }
//
//    public int getReade_timeout() {
//        return reade_timeout;
//    }
//
//    public void setReade_timeout(int reade_timeout) {
//        this.reade_timeout = reade_timeout;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public void setEncode(String encode) {
//        this.encode = encode;
//    }
//
//    public void setCookie(String cookie) {
//        this.cookie = cookie;
//    }
//
//    public RemitHttpClient() {
//    }
//
//    public void init() {
//        httpClientInit(DEFAULT_HTTP_PORT, connect_timeout, reade_timeout);
//    }
//
//    public RemitHttpClient(int ctimeout, int rtimeout) {
//        httpClientInit(DEFAULT_HTTP_PORT, ctimeout, rtimeout);
//    }
//
//    public RemitHttpClient(int httpPort, int ctimeout, int rtimeout) {
//        httpClientInit(httpPort, ctimeout, rtimeout);
//    }
//
//    public void httpClientInit(int httpPort, int ctimeout, int rtimeout) {
//        // 注册响应类型
//        SchemeRegistry schemeRegistry = new SchemeRegistry();
//        schemeRegistry.register(new Scheme("http", httpPort, PlainSocketFactory.getSocketFactory()));
//        // 创建一个线程安全的HTTP连接池
//        connectionManager = new ThreadSafeClientConnManager(schemeRegistry);
//        // 最大连接数（所有Host加起来）
//        connectionManager.setMaxTotal(MAX_TOTAL_CONNECTIONS);
//        // 每个Host最多连接数
//        connectionManager.setDefaultMaxPerRoute(MAX_ROUTE_CONNECTIONS);
//        httpParam = new BasicHttpParams();
//        // 设置连接建立超时
//        HttpConnectionParams.setConnectionTimeout(httpParam, ctimeout);
//        // 设置数据等待超时
//        HttpConnectionParams.setSoTimeout(httpParam, rtimeout);
//    }
//
//    public String sendPostRequest(String requestXML) {
//        if (url == null || url.equals("") || encode == null || encode.equals("") || cookie == null || cookie.equals(""))
//            return "必填参数没有输入";
////        logger.info("HttpClient方式调用开始");
//        String responseContent = null;
//        DefaultHttpClient httpClient = new DefaultHttpClient(connectionManager, httpParam);
//        // 重试机制禁用
//        DefaultHttpRequestRetryHandler retryHandler = new DefaultHttpRequestRetryHandler(0, false);
//        httpClient.setHttpRequestRetryHandler(retryHandler);
//        HttpPost httpPost = new HttpPost(url);
//        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=" + encode);   //utf-8
//        httpPost.addHeader("Cookie", cookie);
//
//        try {
//            //构建POST请求的表单参数
//            httpPost.setEntity(new StringEntity(requestXML, encode)); //utf-8
//            HttpResponse response = httpClient.execute(httpPost);
//
//            //取得相应码
//            int responseCode = response.getStatusLine().getStatusCode();
//            if (responseCode != HTTP_OK) {
////                logger.error("http通信失败，响应码：[" + responseCode + "]");
////                throw new RemitException(RemitErrorEnum.CONNECT_ERROR, "http通信失败,响应码为{0}", responseCode);// TODO 异常码
//            }
//            HttpEntity entity = response.getEntity();
//            if (null != entity) {
//                responseContent = EntityUtils.toString(entity, encode);
//                EntityUtils.consume(entity);
//            }
//
////            logger.info("请求返回报文： " + responseContent);
////            logger.info("HttpClient方式调用结束");
//        } catch (ConnectTimeoutException cte) {
////            logger.error("请求通信[" + reqURL + "]时连接超时,堆栈轨迹如下", cte);
////            throw new RemitException(RemitErrorEnum.CONNECT_ERROR, "请求通信[" + reqURL + "]时连接超时,Ctimeout:"+ctimeout, cte);// TODO 异常码
//        } catch (SocketTimeoutException ste) {
////            logger.error("请求通信[" + reqURL + "]时读取超时,堆栈轨迹如下", ste);
////            throw new RemitException(RemitErrorEnum.CONNECT_ERROR, "请求通信[" + reqURL + "]时响应超时,Rtimeout:"+rtimeout, ste);// TODO 异常码
//        } catch (Exception e) {
////            logger.error("请求通信[" + reqURL + "]时偶遇异常,堆栈轨迹如下", e);
////            throw new RemitException(RemitErrorEnum.CONNECT_ERROR, "请求通信[" + reqURL + "]未知异常", e);// TODO 异常码
//        } finally {
//            // httpClient.getConnectionManager().shutdown();
//        }
//        return responseContent;
//    }
//
//    public static void main(String[] args) {
//        RemitHttpClient httpClientUtil = new RemitHttpClient();
//
//        String url = "http://internal-shop-dp-internal-1679419227.cn-north-1.elb.amazonaws.com.cn/smsApi/send";
//        httpClientUtil.setEncode("utf-8");
//        httpClientUtil.setUrl(url);
//        httpClientUtil.setCookie("appName=javaMonitor;appKey=8A1B38D2B1A5E232;");
//
//        String str = "type=2&mobile=13716403349&content=尊敬的用户:你中了一个iPhone7请到www.chuchujie.com领取";
//
//        message(httpClientUtil, str);
////        String responseContent = httpClientUtil.sendPostRequest(str);
////        JSONObject jsonObject = null;
////        try {
////            //json字符串转换成json对象
////            jsonObject = JSON.parseObject(responseContent);
////            System.out.println("ss" + jsonObject);
////            int i = (int) jsonObject.get("error");
////            JSONObject j = jsonObject.getJSONObject("data");
////            String success = j.get("success").toString();
////            String msg = j.get("msg").toString();
////            System.out.println("i:" + i + ",success:" + success + ",msg:" + msg);
////        } catch (JSONException e1) {
////        }
////        System.out.println("result:" + responseContent);
//    }
//
//    private static void message(RemitHttpClient httpClient, String str) {
//        System.out.println("#短信请求参数:" + str);
//        String responseContent = null;
//        try {
//            JSONObject jsonObject = null;
////            httpClient.setEncode(charSet);
////            httpClient.setCookie(cookie);
////            httpClient.setUrl(url);
//            responseContent = httpClient.sendPostRequest(str);
//            System.out.println("#发送短信返回结果result:" + responseContent);
//            // json字符串转换成json对象
//            jsonObject = JSON.parseObject(responseContent);
//            int i = (int) jsonObject.get("error");
//            if (i == ResultCode.NORMAL.getCode()) {
//                //{success:1,msg:''} success成功数 msg 失败消息 只有当error为0时才会有该字段
//                JSONObject j = jsonObject.getJSONObject("data");
//                String success = j.get("success").toString();
//                if (success.equals(1)) ;
//                String msg = j.get("msg").toString();
//            } else if (i == ResultCode.URL_ERROR.getCode()) {
//                System.out.println("url错误");
//                return;
//            } else if (i == ResultCode.PARAM_ERROR.getCode()) {
//                System.out.println("参数错误");
//                return;
//            } else if (i == ResultCode.SERVER_Exception.getCode()) {
//                System.out.println("服务器异常");
//                return;
//            } else if (i == ResultCode.AUTHENTICAT_ERROR.getCode()) {
//                System.out.println("权限认证失败");
//                return;
//            } else if (i == ResultCode.SEND_ERROR.getCode()) {
//                System.out.println("发送失败");
//                return;
//            } else {
//                System.out.println("未知异常");
//                return;
//            }
//        } catch (JSONException e1) {
//            System.out.println("#返回结果responseContent-json字符串转换成json对象异常:" + e1);
//        } catch (Exception e) {
//            System.out.println("#未知异常:" + e);
//        }
//        System.out.println("#短信发送结束");
//    }
//
//    enum ResultCode {
//        NORMAL(0, "正常"),
//        URL_ERROR(1, "url错误"),
//        PARAM_ERROR(2, "参数错误"),
//        SERVER_Exception(3, "服务器异常"),
//        AUTHENTICAT_ERROR(4, "权限认证失败"),
//        SEND_ERROR(5, "发送失败");
//        private int code;
//        private String description;
//
//        ResultCode() {
//        }
//
//        ResultCode(int code, String description) {
//            this.code = code;
//            this.description = description;
//        }
//
//        public int getCode() {
//            return code;
//        }
//
//        public void setCode(int code) {
//            this.code = code;
//        }
//
//        public String getDescription() {
//            return description;
//        }
//
//        public void setDescription(String description) {
//            this.description = description;
//        }
//    }
//
//}
