package com.ApiGateway.Repository;



	import java.util.List;

	import org.springframework.beans.factory.annotation.Qualifier;
	import org.springframework.data.domain.Page;
	import org.springframework.data.domain.Pageable;
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.data.repository.query.Param;
	import org.springframework.stereotype.Repository;

import com.ApiGateway.entity.UserEntity;



	@Repository
	public interface UserRepository extends JpaRepository<UserEntity, Long>{

		UserEntity findByEmailIgnoreCase(String email);
		
		List<UserInterface> findById(long id , Class<UserInterface>class1);
		
		@Query(value = "select u.name, r.roles,p.permissions  from user_entity u\r\n"
				+ "join user_roles_entity ure on u.id=ure.users_id\r\n"
				+ "join roles r on ure.roles_id=r.id\r\n"
				+ "join roles_permission_entity rpe on r.id=rpe.role_entity_id\r\n"
				+ "join permissions p on p.id=rpe.permissions_id where u.id= :idnumber",nativeQuery = true)
		List<UserPermission> getPermission(@Param("idnumber")  long id , Class<UserPermission> class1);

		
//		@Query(value = "select u.name, u.email, u.city, u.state , u.mobile_no from user_entity u",nativeQuery = true)
//		List<UserInterface> findAll(Class<UserInterface> class1);

		
		@Query(value = "select u.name, u.email, u.city, u.state , u.mobile_no from user_entity u",nativeQuery = true)
		Page<UserInterface> findAll(Pageable pageable, Class<UserInterface> class1);
		
		@Query(value = "select u.name ,u.email, j.company, j.jobs, j.role from user_entity u\r\n"
				+ "join user_jobs_entity uje on uje.user_entity_id = u.id\r\n"
				+ "join jobs_entity j on j.id = uje.job_entity_id",nativeQuery = true)
		List<UsersJobsInterface> findAll(Class<UsersJobsInterface>class1);
		
		@Query(value = "select u.name ,u.email, j.company, j.jobs, j.role from user_entity u\r\n"
				+ "join user_jobs_entity uje on uje.user_entity_id = u.id\r\n"
				+ "join jobs_entity j on j.id = uje.job_entity_id",nativeQuery = true)
		List<JobsUsersInterface> findall(Class<JobsUsersInterface> class1);
		
		
		
		
	}


