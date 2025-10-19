import java.util.*;

public class HttpStatusDictionary {
    private Map<Integer, String> statusCodes;
    private Random random; // Добавляем Random как поле класса
    
    public HttpStatusDictionary() {
        statusCodes = new HashMap<>();
        random = new Random(); // Инициализируем Random
        initializeCodes();
    }
    
    private void initializeCodes() {
        // 1xx: Information
        /*statusCodes.put(100, "Continue");
        statusCodes.put(101, "Switching Protocols");
        statusCodes.put(102, "Processing");
        statusCodes.put(103, "Early Hints");
        */
        
        // 2xx: Success
        /*statusCodes.put(200, "OK");
        statusCodes.put(201, "Created");
        statusCodes.put(202, "Accepted");
        statusCodes.put(204, "No Content");
        statusCodes.put(206, "Partial Content");
        */

        // 3xx: Redirection
        //statusCodes.put(300, "Multiple Choices");
        statusCodes.put(301, "Moved Permanently");
        statusCodes.put(302, "Found");
        statusCodes.put(303, "See Other");
        statusCodes.put(304, "Not Modified");
        //statusCodes.put(307, "Temporary Redirect");
        //statusCodes.put(308, "Permanent Redirect");
        
        // 4xx: Client Errors
        statusCodes.put(400, "Bad Request");
        statusCodes.put(401, "Unauthorized");
        // statusCodes.put(403, "Forbidden");
        //statusCodes.put(404, "Not Found");
        statusCodes.put(405, "Method Not Allowed");
        statusCodes.put(406, "Not Acceptable");
        statusCodes.put(408, "Request Timeout");
        //statusCodes.put(409, "Conflict");
        //statusCodes.put(429, "Too Many Requests");
        
        // 5xx: Server Errors
        //statusCodes.put(500, "Internal Server Error");
        statusCodes.put(501, "Not Implemented");
        //statusCodes.put(502, "Bad Gateway");
        statusCodes.put(503, "Service Unavailable");
        //statusCodes.put(504, "Gateway Timeout");
    }
    
    // НОВЫЙ МЕТОД: получить случайный код (число)
    public int getRandomStatusCode() {
        List<Integer> keys = new ArrayList<>(statusCodes.keySet());
        return keys.get(random.nextInt(keys.size()));
    }
    
    // Метод: получить случайный код с описанием (у вас уже есть)
    public Map.Entry<Integer, String> getRandomStatusEntry() {
        List<Map.Entry<Integer, String>> entries = 
            new ArrayList<>(statusCodes.entrySet());
        return entries.get(random.nextInt(entries.size()));
    }
    
    public String getDescription(int code) {
        return statusCodes.getOrDefault(code, "Unknown status code");
    }
    
    public boolean containsCode(int code) {
        return statusCodes.containsKey(code);
    }
    
    public void printAllCodes() {
        System.out.println("HTTP Status Codes Dictionary:");
        for (Map.Entry<Integer, String> entry : statusCodes.entrySet()) {
            System.out.printf("%d - %s%n", entry.getKey(), entry.getValue());
        }
    }
}