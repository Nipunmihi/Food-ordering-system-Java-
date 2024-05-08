package mngFooditems;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class FoodServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private FoodDAO foodDAO;

    public FoodServlet() {
        this.foodDAO = new FoodDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doHead(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                try {
                    insertFood(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/delete":
                try {
                    deleteFood(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/edit":
                try {
                    showEditForm(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/update":
                try {
                    updateFood(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
                
                
            case "/view":
                try {
                	listFoodCus(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
                
                
            default:
                try {
                    listFood(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void listFood(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List<Food> listFood = foodDAO.selectAllFoods();
        request.setAttribute("listFood", listFood);
        RequestDispatcher dispatcher = request.getRequestDispatcher("food-list.jsp");
        dispatcher.forward(request, response);
      
    }
    
    //-------------------------------
    private void listFoodCus(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List<Food> foodList = foodDAO.selectAllFoods();
        request.setAttribute("foodList", foodList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cus-list-food.jsp");
        dispatcher.forward(request, response);
    }
    
    //------------------------------
    
    

    private void updateFood(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String favour = request.getParameter("favour");

        Food food = new Food(id, name, price, favour);
        foodDAO.updateFood(food);
        response.sendRedirect("list");
    }

    private void deleteFood(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        foodDAO.deleteFood(id);
        response.sendRedirect("list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Food existingFood = foodDAO.selectFood(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("food-form.jsp");
        request.setAttribute("food", existingFood);
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("food-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertFood(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String favour = request.getParameter("favour");
        Food newFood = new Food(name, price, favour);
        foodDAO.insertFood(newFood);
        response.sendRedirect("list");
    }
}
