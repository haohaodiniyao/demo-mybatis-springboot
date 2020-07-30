mybatis-spring-boot-starter
mysql
主从库切换
新增返回主键
<insert id="insert" parameterType="com.example.entity.User" useGeneratedKeys="true" keyColumn="user_id" keyProperty="userId">