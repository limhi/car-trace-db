:begin
/package/,/String/ {
    /String/! {
        $! {
            N;
             b begin
        }
    }
    s/import java.io.Serializable;\n\n//g;
    s/\ implements\ Serializable//g;
    s/public class/import java.io.Serializable;\n\npublic class/g;
    s/{/implements Serializable\ {/g;
}

