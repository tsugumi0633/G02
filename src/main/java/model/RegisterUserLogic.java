package model;

import dao.UsersDAO;

public class RegisterUserLogic {
//
//    private List<User> registeredUsers = new ArrayList<>(); 
//
//    public boolean register(User user) {
//        for (User registeredUser : registeredUsers) {
//            if (registeredUser.getId().equals(user.getId())) {
//                return false; 
//            }
//        }
//        registeredUsers.add(user);
//        return true; 
//    }
//
//    public List<User> getRegisteredUsers() {
//        return registeredUsers;
//    }

	 public boolean execute(User user) {
	        UsersDAO dao = new UsersDAO();
	        User returnUser = dao.create(user.getEmail(),user.getPass(),user.getName());
	        if (returnUser != null) {
	            return true;
	        } else {
	        	return false;
	        }
    	}

    }

