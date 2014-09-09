:begin
/<resultMap id="BaseResultMap"/,/<\/resultMap>/ {
    /<\/resultMap>/! {
        $! {
            N;
             b begin
        }
    }
    s/<\/resultMap>/<\/resultMap>\n\n  <resultMap id="myMap" type="java.util.HashMap" \/>\n\n/g;
}
