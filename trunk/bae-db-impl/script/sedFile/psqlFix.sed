:begin
/<select id="selectByExample"/,/<\/select>/ {
    /<\/select>/! {
        $! {
            N;
             b begin
        }
    }
    s/    )\n    where RN between/    ) as mytable\n    where RN between/g;
}
