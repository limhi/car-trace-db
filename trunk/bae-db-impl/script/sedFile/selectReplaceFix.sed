:begin
/<if test="example.orderByClause != null"/,/<\/if>/ {
    /<\/select>/! {
        $! {
            N;
             b begin
        }
    }
    s/<if test="example.orderByClause != null".*<\/if>//g;
}

/<select id="selectByExample"/,/<\/select>/ {
    /<\/select>/! {
        $! {
            N;
             b begin
        }
    }
    s/(ROW_NUMBER() OVER (/(ROW_NUMBER() OVER (\n    \<if test=\"example\.orderByClause \!= null\"\>\n      order by ${example.orderByClause}\n    \<\/if\>\n    /g;
}
