package com.team_spak.car_rental.service;

import com.team_spak.car_rental.model.User;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
@Service
public class UserService {

        private Map<Long, User> users;

        public void UserRepositoryService() {
            this.users = new HashMap<>();
        }

        // Create
        public void addUser(User user) {
            if (users.containsKey(user.getId())) {
                System.out.println("User with ID " + user.getId() + " already exists.");
            } else {
                users.put(user.getId(), user);
                System.out.println("User added: " + user);
            }
        }

        // Read
        public User getUser(String userId) {
            if (users.containsKey(userId)) {
                return users.get(userId);
            } else {
                System.out.println("Userer with ID " + userId + " not found.");
                return null;
            }
        }

        // Update
        public void updateUser(String userId, String newUserame, String newPassword) {
            if (users.containsKey(userId)) {
                User user = users.get(userId);
                user.setUsername(user.getUsername());
                user.setPassword(user.getPassword());
                System.out.println("User updated: " + user);
            } else {
                System.out.println("User with ID " + userId + " not found.");
            }
        }

        // Delete
        public void deleteUser(String userId) {
            if (users.containsKey(userId)) {
                User removedUser = users.remove(userId);
                System.out.println("User deleted: " + removedUser);
            } else {
                System.out.println("User with ID " + userId + " not found.");
            }
        }

        // List all customers
        public void listCustomers() {
            if (users.isEmpty()) {
                System.out.println("No users found.");
            } else {
                for (User user : users.values()) {
                    System.out.println(user);
                }
            }
        }
    }
