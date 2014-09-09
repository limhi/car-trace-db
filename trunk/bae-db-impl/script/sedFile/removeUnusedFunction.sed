:begin
/<select id="selectByPrimaryKey"/,/<\/select>/ {
    /<\/select>/! {
        $! {
            N;
             b begin
        }
    }
    s/<select id="selectByPrimaryKey".*<\/select>//;
}

/<delete id="deleteByPrimaryKey"/,/<\/delete>/ {
    /<\/delete>/! {
        $! {
            N;
             b begin
        }
    }
    s/<delete id="deleteByPrimaryKey".*<\/sedeletelect>//;
}
