@EnableCaching </br>
@Cacheable(value = "applicationCache", key = "#id")</br>
@Cacheable(value = "applicationCache", key = "#id" unless="#result.id > 10" )</br>
@CachePut(value = "applicationCache", key = "#id")</br>
@CacheEvict(value = "applicationCache", allEntries = true)</br>
@CacheConfig("books")  ---->> Class level , For all the methods of the class. 

 cacheManager.getCacheNames().parallelStream().forEach(name ->cacheManager.getCache(name).clear());

 https://docs.spring.io/spring-boot/docs/3.0.8/reference/html/io.html#io.caching.provider
    
