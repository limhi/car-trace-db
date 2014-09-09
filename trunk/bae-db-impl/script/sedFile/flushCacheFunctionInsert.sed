:begin
/<select id="countByExample"/,/<\/select>/ {
    /<\/select>/! {
        $! {
            N;
             b begin
        }
    }
    s/<select id="countByExample"/\n  <select id="flushCache"  flushCache="true" resultType="java.lang.Integer"\>\n    select 1 from sysibm.sysdummy1\n  <\/select\>\n\n  <select id="countByExample"/g;
}
