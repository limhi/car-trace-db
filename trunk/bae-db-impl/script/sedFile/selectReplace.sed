:begin
/<select id="selectByExample"/,/<\/select>/ {
    /<\/select>/! {
        $! {
            N;
             b begin
        }
    }
    s/    select/    select * from (\n    select/g;
    s/ test=\"distinct/ test=\"example\.distinct/g;
    s/    from /    , (ROW_NUMBER() OVER ())-1 AS RN\n    from /g;
    s/  <\/select>/    ) as mytable\n    where RN between ${record_start} and ${record_stop}\n    fetch first ${record_max_count} rows only\n  <\/select>/g;
}
