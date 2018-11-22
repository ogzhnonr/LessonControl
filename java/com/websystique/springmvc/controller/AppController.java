package com.websystique.springmvc.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.websystique.springmvc.model.Task;
import com.websystique.springmvc.model.TaskDetail;
import com.websystique.springmvc.model.TaskInfo;
import com.websystique.springmvc.model.TaskMilestone;
import com.websystique.springmvc.model.TaskPlan;
import com.websystique.springmvc.model.User;
import com.websystique.springmvc.model.UserProfile;
import com.websystique.springmvc.service.TaskDetailService;
import com.websystique.springmvc.service.TaskInfoDegreeService;
import com.websystique.springmvc.service.TaskInfoService;
import com.websystique.springmvc.service.TaskMilestoneDegreeService;
import com.websystique.springmvc.service.TaskMilestoneService;
import com.websystique.springmvc.service.TaskPlanService;
import com.websystique.springmvc.service.TaskService;
import com.websystique.springmvc.service.UserProfileService;
import com.websystique.springmvc.service.UserService;



@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	TaskPlanService taskPlanService;
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	TaskInfoService taskInfoService;
	
	@Autowired
	TaskDetailService taskDetailService;
	
	@Autowired
	TaskInfoDegreeService taskInfoDegreeService;
	
	@Autowired
	TaskMilestoneService taskMilestoneService;
	
	@Autowired
	TaskMilestoneDegreeService taskMilestoneDegreeService; 
	
	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
	
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
	
	
//	////////////////////////Presentation/////////////////////////
//	/**
//	 * This method will provide the presentation.
//	 */
//	@RequestMapping(value = { "/presentation" }, method = RequestMethod.GET)
//	public String presentation(ModelMap model) {
//		model.addAttribute("loggedinuser", getPrincipal());
//		return "presentation";
//	}
//	/////////////////////////////////////////////////////////////
//	
	
	/////////////TASK PLAN ////////////////////////////////////////
	@RequestMapping(value = { "/taskPlan" }, method = RequestMethod.GET)
	public String taskPlan(ModelMap model) {
		//model.addAttribute("loggedinuser", getPrincipal());
		String userName = getPrincipal();//ayný zamanda SSOID
		
//		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		Date date = new Date();
//		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		
		List<Object[]> taskPlanListJoined = taskPlanService.findAllTaskPlanJoined(userName, new Date(), new Date());
		model.addAttribute("taskPlanListJoined", taskPlanListJoined);
		
		List<Object[]> taskInfoJoined = taskInfoService.findAllTaskInfoJoined(userName);
		model.addAttribute("taskInfoJoined", taskInfoJoined);
		model.addAttribute("loggedinuser", userName);
		
		TaskPlan taskPlan = new TaskPlan();
		model.addAttribute("taskPlan", taskPlan);
		return "taskPlan";
	}
	
	/**
	 * Lists taskPlans for taskList
	 * @param model
	 */
	@RequestMapping(value="/taskPlanListJoined/{startDate}-{endDate}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> taskPlanList(@PathVariable("startDate") Date startDate, @PathVariable("endDate") Date endDate){
		String ssoId = getPrincipal();//ayný zamanda SSOID
		List<Object[]> taskPlanListJoined = taskPlanService.findAllTaskPlanJoined(ssoId, startDate, endDate);
		return taskPlanListJoined;
	}
	
	@RequestMapping(value = {"/taskPlan"}, method = RequestMethod.POST)
	public String updateTaskPlan(@Valid TaskPlan taskPlan, BindingResult result, ModelMap model){
		
		String userName = getPrincipal();//ayný zamanda SSOID
		model.addAttribute("loggedinuser", userName);
		if (result.hasErrors()) {
			return "registration";
		}
		
		taskPlanService.updateTaskPlan(taskPlan);
		//TaskPlan taskPlan = taskPlanService.findById(selectedId);
		List<Object[]> taskInfoJoined = taskInfoService.findAllTaskInfoJoined(userName);
		model.addAttribute("taskInfoJoined", taskInfoJoined);
		
		return "taskPlan";
	}
	
	//////////////////////////////////////////////////////////////
	
	////////////////////////Dashboard////////////////////////////
	
	/**
	 * This method will provide the dashboard.
	 */
	@RequestMapping(value = { "/", "/dashboard" }, method = RequestMethod.GET)
	public String dashboard(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		return "dashboard";
	}
	
	/////////////////////////////////////////////////////////////
	
	//////////////////////User////////////////////////
	/**
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "/newuseranonymus" }, method = RequestMethod.GET)
	public String newUserAnonymus(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("generalRoles", getGeneralProfiles());
		model.addAttribute("edit", false);
		return "registrationAnonymus";
	}
	
	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newuseranonymus" }, method = RequestMethod.POST)
	public String saveUserAnonymus(@Valid User user, BindingResult result,
			ModelMap model) {

		model.addAttribute("generalRoles", getGeneralProfiles());
		if (result.hasErrors()) {
			return "registrationAnonymus";
		}

		/*
		 * Preferred way to achieve uniqueness of field [sso] should be implementing custom @Unique annotation 
		 * and applying it on field [sso] of Model class [User].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 * 
		 */
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registrationAnonymus";
		}
		
		if (!userService.isUserEmailUnique(user.getId(), user.getEmail())){
			FieldError emailError = new FieldError("user", "email", messageSource.getMessage("non.unique.email", new String[]{user.getSsoId()}, Locale.getDefault()));
			result.addError(emailError);
			return "registrationAnonymus";
		}
		
		userService.saveUser(user);

		model.addAttribute("success", user.getFirstName() + " "+ user.getLastName() + " kaydedildi.");
		model.addAttribute("successfullRegistration", true);
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "login";
	}
	
	/**
	 * This method will list all existing users.
	 */
	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {

		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		model.addAttribute("loggedinuser", getPrincipal());
		return "userslist";
	}

	/**
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registration";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			model.addAttribute("loggedinuser", getPrincipal());
			return "registration";
		}

		/*
		 * Preferred way to achieve uniqueness of field [sso] should be implementing custom @Unique annotation 
		 * and applying it on field [sso] of Model class [User].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 * 
		 */
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}
		
		userService.saveUser(user);

		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " registered successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "registrationsuccess";
	}


	/**
	 * This method will provide the medium to update an existing user.
	 */
	@RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable String ssoId, ModelMap model) {
		User user = userService.findBySSO(ssoId);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		model.addAttribute("userProfile", (getUserProfiles(model).getType().equals("USER")));
		model.addAttribute("userProfileType", getUserProfiles(model).getType());
		model.addAttribute("loggedinuser", getPrincipal());
		return "registration";
	}
	
	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result,
			ModelMap model, @PathVariable String ssoId) {

		if (result.hasErrors()) {
			model.addAttribute("loggedinuser", getPrincipal());
			return "registration";
		}

		/*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/


		userService.updateUser(user);

		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationsuccess";
	}
		
	/**
	 * This method will delete an user by it's SSOID value.
	 */
	@RequestMapping(value = { "/delete-user-{ssoId}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable String ssoId) {
		userService.deleteUserBySSO(ssoId);
		return "redirect:/list";
	}
	
	/**
	 * This method will provide General UserProfile list to views
	 */
	public List<UserProfile> getGeneralProfiles() {
		int i = 0;
		
		List<UserProfile> upsNew = userProfileService.findGeneralProfiles();
		List<UserProfile> ups = userProfileService.findGeneralProfiles();
		for (Iterator<UserProfile> itr = ups.iterator(); itr.hasNext();)
		{
			String roleName = itr.next().getType();
			if (roleName.equals("USER"))
			{
				upsNew.remove(i);
				upsNew.add(i, new UserProfile(1, "Öðrenci"));
				//ups.set(i, new UserProfile(i, "Öðrenci"));
			}
			else if (roleName.equals("PARENT"))
			{
				upsNew.remove(i);
				upsNew.add(i, new UserProfile(3, "Ebeveyn"));
				//ups.set(i, new UserProfile(i, "Ebeveyn"));
			}
			i++;
		}
		return upsNew;
	}

	/**
	 * This method will provide UserProfile list to views
	 */
	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		return userProfileService.findAll();
	}
	
	protected UserProfile getUserProfiles(ModelMap model)
	{
		User user = userService.findBySSO(getPrincipal());
		return userService.getUserProfile(user).get(0);
	}
	
	//////////////////////User////////////////////////

	//////////////////////Task////////////////////////
	/**
	 * This method will list all existing tasks.
	 */
	@RequestMapping(value = { "/listTasks" }, method = RequestMethod.GET)
	public String listTasks(ModelMap model) {
		
		List<Task> tasks = taskService.findAllTasks();
		model.addAttribute("tasks", tasks);
		model.addAttribute("loggedinuser", getPrincipal());
		
		return "tasksList";
	}
	
	/**
	 * This method will provide the medium to add a new task.
	 */
	@RequestMapping(value = { "/newtask" }, method = RequestMethod.GET)
	public String newTask(ModelMap model) {
		Task task = new Task();
		model.addAttribute("task", task);
		//model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationTask";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newtask" }, method = RequestMethod.POST)
	//public String saveTask(@Valid Task task, BindingResult result, ModelMap model)
	public String saveTask(@Valid Task task, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			model.addAttribute("loggedinuser", getPrincipal());
			return "registrationTask";
		}

		taskService.save(task);

		model.addAttribute("success", "Task " + task.getTaskId() + " "+ task.getTaskName() + " registered successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "registrationsuccess";
	}
		
	/**
	 * This method will delete a task by it's TASKID value.
	 */
	@RequestMapping(value = { "/delete-task-{taskId}" }, method = RequestMethod.GET)
	public String deleteTask(@PathVariable int taskId) {
		taskService.deleteByTaskId(taskId);
		return "redirect:/listTasks";
	}
	
	////////////////////Task////////////////////////
	
	////////////////////Task Info////////////////////////
	/**
	 * This method will list all existing taskInfo.
	 */
	@RequestMapping(value = { "/listTaskInfo" }, method = RequestMethod.GET)
	public String listTaskInfo(ModelMap model) {
		String userName = getPrincipal();//ayný zamanda SSOID
		List<Object[]> taskInfoJoined = taskInfoService.findAllTaskInfoJoined(userName);
		model.addAttribute("taskInfoJoined", taskInfoJoined);
		List<TaskInfo> taskInfo = taskInfoService.findAllTaskInfo(userName);
		model.addAttribute("taskInfos", taskInfo);
		model.addAttribute("loggedinuser", getPrincipal());
		return "taskInfoList";
	}
	
	/**
	 * Lists tasks for dropdown
	 * @param model
	 */
	@RequestMapping(value="/taskListDD", method = RequestMethod.GET)
	public ModelMap initTaskList(ModelMap model){
		HashMap<Object, Object> taskList = taskService.findAllTasksForDropdown();
		model.addAttribute("taskListDD", taskList);
		return model;
	}
	
	/**
	 * Lists taskDetails for dropdown
	 * @param model
	 */
	@RequestMapping(value="/taskDetailListDD/{taskId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<TaskDetail> initTaskDetailList(@PathVariable("taskId") int taskId){
		List<TaskDetail> taskDetailList = taskDetailService.findAllTaskDetailForDropdown(taskId);
//		model.addAttribute("taskDetailListDD", taskDetailList);
		return taskDetailList;
	}
	
	/**
	 * This method will provide the medium to add a new taskInfo.
	 */
	@RequestMapping(value = { "/newTaskInfo" }, method = RequestMethod.GET)
	public String newTaskInfo(ModelMap model) {
		TaskInfo taskInfo = new TaskInfo();
		model.addAttribute("taskInfo", taskInfo);
		//model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		initTaskList(model);
		return "registrationTaskInfo";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newTaskInfo" }, method = RequestMethod.POST)
	//public String saveTaskInfo(@Valid TaskInfo taskInfo, TaskInfoDegree taskInfoDegree, BindingResult result, ModelMap model) {
	public String saveTaskInfo(@Valid TaskInfo taskInfo, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			initTaskList(model);
			model.addAttribute("loggedinuser", getPrincipal());
			return "registrationTaskInfo";
		}

		taskInfoService.save(taskInfo);
		//taskInfoDegreeService.save(taskInfoDegree);
		initTaskList(model);
		model.addAttribute("success", "TaskInfo " + taskInfo.getTaskInfoId() + " registered successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		
		return "registrationTaskInfo";
	}
		
	/**
	 * This method will delete a task by it's TASKID value.
	 */
	@RequestMapping(value = { "/delete-taskInfo-{taskInfoId}" }, method = RequestMethod.GET)
	public String deleteTaskInfo(@PathVariable int taskInfoId) {
		String userName = getPrincipal();//ayný zamanda SSOID
		taskInfoService.deleteByTaskInfoId(userName, taskInfoId);
		return "redirect:/listTaskInfo";
	}
	///////////////////////////////////////////////////////
	
	
	//////////////////// Task Detail////////////////////////
	/**
	 * This method will list all existing taskDetail.
	 */
	@RequestMapping(value = { "/listTaskDetail" }, method = RequestMethod.GET)
	public String listTaskDetail(ModelMap model) {

		List<TaskDetail> taskDetail = taskDetailService.findAllTaskDetails();
		model.addAttribute("taskDetail", taskDetail);
		model.addAttribute("loggedinuser", getPrincipal());
		return "taskDetailList";
	}

	/**
	 * This method will provide the medium to add a new taskDetail.
	 */
	@RequestMapping(value = { "/newTaskDetail" }, method = RequestMethod.GET)
	public String newTaskDetail(ModelMap model) {
		TaskDetail taskDetail = new TaskDetail();
		model.addAttribute("taskDetail", taskDetail);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationTaskDetail";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newTaskDetail" }, method = RequestMethod.POST)
	public String saveTaskDetail(@Valid TaskDetail taskDetail, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			model.addAttribute("loggedinuser", getPrincipal());
			return "registrationTaskDetail";
		}

		taskDetailService.save(taskDetail);

		model.addAttribute("success", "TaskDetail " + taskDetail.getTaskDetailId() + " registered successfully");
		model.addAttribute("loggedinuser", getPrincipal());

		return "registrationsuccess";
	}

	/**
	 * This method will delete a task by it's TASKDETAILID value.
	 */
	@RequestMapping(value = { "/delete-taskDetail-{taskDetailId}" }, method = RequestMethod.GET)
	public String deleteTaskDetailByTaskDetailId(@PathVariable int taskDetailId) {
		taskDetailService.deleteByTaskDetailId(taskDetailId);
		return "redirect:/listTaskDetail";
	}
	
	/**
	 * This method will delete a task by it's TASKID value.
	 */
	@RequestMapping(value = { "/delete-taskDetail-{taskId}" }, method = RequestMethod.GET)
	public String deleteTaskDetailByTaskId(@PathVariable int taskId) {
		taskDetailService.deleteByTaskDetailId(taskId);
		return "redirect:/listTaskDetail";
	}
	///////////////////////////////////////////////////////
	
	
	//////////////////////Task Milestone////////////////////////
	/**
	 * This method will list all existing taskMilestone.
	 */
	@RequestMapping(value = { "/listTaskMilestone" }, method = RequestMethod.GET)
	public String listTaskMilestone(ModelMap model) {
		String userName = getPrincipal();//ayný zamanda SSOID
		List<TaskMilestone> taskMilestone = taskMilestoneService.findAllTaskmilestones(userName);
		model.addAttribute("taskMilestones", taskMilestone);
		model.addAttribute("loggedinuser", getPrincipal());
		return "taskMilestoneList";
	}
	
	/**
	 * This method will list all existing taskMilestones for sözel
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/listTaskMilestoneSzl" }, method = RequestMethod.GET)
	public String listTaskMilestoneSzl(ModelMap model) {
		String userName = getPrincipal();//ayný zamanda SSOID
		List<TaskMilestone> taskMilestoneSzl = taskMilestoneService.findAllTaskmilestones(userName);
		model.addAttribute("taskMilestonesSzl", taskMilestoneSzl);
		model.addAttribute("loggedinuser", getPrincipal());
		return "taskMilestoneListSzl";
	}
	
	/**
	 * This method will list all existing taskMilestones for eþit aðýrlýk
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/listTaskMilestoneEA" }, method = RequestMethod.GET)
	public String listTaskMilestoneEA(ModelMap model) {
		String userName = getPrincipal();//ayný zamanda SSOID
		List<TaskMilestone> taskMilestoneEA = taskMilestoneService.findAllTaskmilestones(userName);
		model.addAttribute("taskMilestonesEA", taskMilestoneEA);
		model.addAttribute("loggedinuser", getPrincipal());
		return "taskMilestoneListEA";
	}

	/**
	 * This method will provide the medium to add a new taskMilestone.
	 */
	@RequestMapping(value = { "/newTaskMilestone" }, method = RequestMethod.GET)
	public String newTaskMilestone(ModelMap model) {
		TaskMilestone taskMilestone = new TaskMilestone();
		model.addAttribute("taskMilestone", taskMilestone);
		// model.addAttribute("edit", false);
		String userName = getPrincipal();//ayný zamanda SSOID
		model.addAttribute("loggedinuser", userName);
		TaskMilestone taskMilestoneEntity = taskMilestoneService.getLastTaskMilestoneBySsoId(userName);
		model.addAttribute("lastTaskMilestoneByUserId", (taskMilestoneEntity == null ? 1 : taskMilestoneEntity.getDenemeId() + 1));
		
		return "registrationTaskMilestone";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newTaskMilestone" }, method = RequestMethod.POST)
	// public String saveTask(@Valid Task task, BindingResult result, ModelMap
	// model)
	public String saveTaskMilestone(@Valid TaskMilestone taskMilestone, BindingResult result, ModelMap model) {//, TaskMilestoneDegree taskMilestoneDegree

		if (result.hasErrors()) {
			model.addAttribute("loggedinuser", getPrincipal());
			return "registrationTaskMilestone";
		}

		taskMilestoneService.save(taskMilestone);
		//taskMilestoneDegreeService.save(taskMilestoneDegree);

		model.addAttribute("success", "TaskMilestone " + taskMilestone.getDenemeId() + " registered successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		// return "success";
		return "registrationTaskMilestone";
	}

	/**
	 * This method will delete a taskMilestone by it's denemeId value.
	 */
	@RequestMapping(value = { "/delete-taskMilestone-{denemeId}" }, method = RequestMethod.GET)
	public String deleteTaskMilestone(@PathVariable int denemeId) {
		String userName = getPrincipal();//ayný zamanda SSOID
		taskMilestoneService.deleteByDenemeId(userName, denemeId);
		return "redirect:/listTaskMilestone";
	}
	///////////////////////////////////////////////////////	
	
	///////////////CalculateScore////////////////////////////
	/**
	 * This method will provide the dashboard.
	 */
	@RequestMapping(value = { "/calculateScore" }, method = RequestMethod.GET)
	public String calculateScore(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		return "CalculateScore";
	}
	///////////////CalculateScore////////////////////////////
	
	/**
	 * This method handles Access-Denied redirect.
	 */
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		return "accessDenied";
	}

	/**
	 * This method handles login GET requests.
	 * If users is already logged-in and tries to goto login page again, will be redirected to list page.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		if (isCurrentAuthenticationAnonymous()) {
			return "login";
	    } else {
	    	return "redirect:/dashboard";  
	    }
	}

	/**
	 * This method handles logout requests.
	 * Toggle the handlers if you are RememberMe functionality is useless in your app.
	 */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			//new SecurityContextLogoutHandler().logout(request, response, auth);
			persistentTokenBasedRememberMeServices.logout(request, response, auth);
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/login?logout";
	}

	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	/**
	 * This method returns true if users is already authenticated [logged-in], else false.
	 */
	private boolean isCurrentAuthenticationAnonymous() {
	    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    return authenticationTrustResolver.isAnonymous(authentication);
	}
	
	


}