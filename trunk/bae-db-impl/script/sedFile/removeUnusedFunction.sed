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
    s/<delete id="deleteByPrimaryKey".*<\/delete>//;
}

/<update id="updateByPrimaryKeySelective"/,/<\/update>/ {
    /<\/update>/! {
        $! {
            N;
             b begin
        }
    }
    s/<update id="updateByPrimaryKeySelective".*<\/update>//;
}

/<update id="updateByPrimaryKey"/,/<\/update>/ {
    /<\/update>/! {
        $! {
            N;
             b begin
        }
    }
    s/<update id="updateByPrimaryKey".*<\/update>//;
}

