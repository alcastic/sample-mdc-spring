# Sample MDC Spring

Sample app that add MDC strategy in order to enrich log in a multi thread system.

MDC capability is added to a Spring web project through Logback library features.
    
# Importat files:

  **./src/main/java/resources/logback.xml** -> Logback Configuration.
  **./src/main/java/cl/acc/mdc/samplemdcspring/MDCFilter** -> Filter that enrich MDC entries.
  
  
# App explanation
  
To each new incoming request MDCFilter will verify if `requestId` http header is present and will add it to MDC entries to start logging it from now on.
If it's not, then MDCFilter will generate and assign one.
Ex. log output:

`2018-08-242 12:57:01.426 INFO  6208 --- requestId=10e11ebf-1859-4404-b1cd-bd4d9745dcd1 --- [http-nio-8080-exec-2] c.a.m.s.GreetingController - Reached greeting`
  
# Run App
  
In your terminal execute:
  
      $ ./gradlew bootRun