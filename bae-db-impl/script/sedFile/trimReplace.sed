:begin
/<insert id="insertSelective"/,/<\/insert>/ {
    /<\/insert>/! {
        $! {
            N;
             b begin
        }
    }
    s/parameterType="map"/parameterType="map"\ useGeneratedKeys="true"\ keyProperty="record\.id"/g;
    s/test="/test="record\./g;
    s/#{/#{record\./g;
}
