:begin
/<update id="updateByExample"/,/<\/update>/ {
    /<\/update>/! {
        $! {
            N;
             b begin
        }
    }
    s/<update id="updateByExample".*<\/update>//;
}
