:begin
/<select id="countByExample"/,/<\/select>/ {
    /<\/select>/! {
        $! {
            N;
             b begin
        }
    }
    s/<select id="countByExample"/\n  <select id="functionByParameterAndExample" parameterType="map"\n    resultMap="myMap"\>\n    select\n    <choose\>\n      <when test="functionParameter != null and functionParameter != ''"\>\n        ${functionParameter}\n      <\/when\>\n      <otherwise\>\n        *\n      <\/otherwise\>\n    <\/choose\>\n    from ${dbschema}.L_AMBRY\n    <if test="example != null"\>\n      <include refid="Example_Where_Clause" \/\>\n    <\/if\>\n  <\/select\>\n  \n  <select id="countByExample"/g;
}
