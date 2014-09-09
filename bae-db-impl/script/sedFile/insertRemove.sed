:begin
/<insert id="insert"/,/<\/insert>/ {
    /<\/insert>/! {
        $! {
            N;
             b begin
        }
    }
    s/<insert id="insert".*<\/insert>//;
}
