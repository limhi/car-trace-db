:begin
/<select id="countByExample"/,/<\/select>/ {
    /<\/select>/! {
        $! {
            N;
             b begin
        }
    }
    s/<select id="countByExample"/\n  <update id="updateNullByIdAndColumn" parameterType="map"\>\n    update ${dbschema}.L_AMBRY\n    <set\>\n      ${tbcolumn} = null,\n      <if test="recIp != null"\>\n        MOD_IP = #{recIp,jdbcType=VARCHAR},\n      <\/if\>\n      <if test="recUser != null"\>\n        MOD_USER = #{recUser,jdbcType=VARCHAR},\n      <\/if\>\n      <if test="recTime != null"\>\n        MOD_TIME = #{recTime,jdbcType=VARCHAR},\n      <\/if\>\n      <if test="recModule != null"\>\n        MOD_MODULE = #{recModule,jdbcType=VARCHAR},\n      <\/if\>\n    <\/set\>\n    <where\>\n      ID in \n      <foreach close=")" collection="recIdList" item="listItem" open="(" separator=","\>\n        #{listItem}\n      <\/foreach\>\n    <\/where\>\n  <\/update\>\n\n  <select id="countByExample"/g;
}
