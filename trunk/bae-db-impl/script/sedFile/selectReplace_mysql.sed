:begin
/<select id="selectByExample"/,/<\/select>/ {
    /<\/select>/! {
        $! {
            N;
             b begin
        }
    }
    s/  <\/select>/    limit ${record_start}, ${record_max_count}\n  <\/select>/g;
}
