:begin
/<resultMap id="BaseResultMap"/,/<\/resultMap>/ {
    /<\/resultMap>/! {
        $! {
            N;
             b begin
        }
    }
    s/<resultMap id="BaseResultMap"/\n  <cache type="org.mybatis.caches.memcached.MemcachedCache" \/>\n\n  <resultMap id="BaseResultMap"/g;
}
