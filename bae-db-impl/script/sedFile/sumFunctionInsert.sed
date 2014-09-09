:begin
/<select id="countByExample"/,/<\/select>/ {
    /<\/select>/! {
        $! {
            N;
             b begin
        }
    }
    s/<select id="countByExample"/\n  <select id="sumByParameterAndExample" parameterType="map"\n    resultType="java.lang.Double"\>\n    select sum(double(${sumParameter})) from ${dbschema}.L_AMBRY\n    <if test="example != null"\>\n      <include refid="Example_Where_Clause" \/\>\n    <\/if\>\n  <\/select\>\n\n  <select id="countByExample"/g;
}
