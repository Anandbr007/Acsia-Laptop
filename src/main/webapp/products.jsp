<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%> 
<%@ page import="java.io.*,java.util.*,java.sql.*"%>  
<%@ page import="javax.servlet.http.*,javax.servlet.*" %> 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Acsia Laptop</title>
    <link rel="stylesheet" href="products.css">
    <link rel="stylesheet" href="fontawesome-free-6.4.2-web/fontawesome-free-6.4.2-web/css/all.css">
    <script src="https://cdn.lordicon.com/lordicon.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    <script>
        let cartCount = 1;
    
        function addToCart() {
           
            document.getElementById('addToCartButton').classList.add('hidden');
    
           
            document.getElementById('cartSection').classList.remove('hidden');
        }
    
        function increment() {
            var input = document.getElementById('cartCount');
            var value = parseInt(input.value, 10);
            input.value = value + 1;
        }
    
        function decrement() {
            var input = document.getElementById('cartCount');
            var value = parseInt(input.value, 10);
            if (value > 1) {
                input.value = value - 1;
            }
        }
    </script>
</head>
<body>

<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"  
     url="jdbc:mysql://localhost/laptop_store"  
     user="root"  password="root"/> 
     
    <div class="containers1">
        <div class="rows1">
            <nav>
                <label class="logo"><a href="home.html">Acsia Laptops</a></label>

                
                <ul>
                    <li><a href="customerDash.html">Home</a></li>
                    <li><a href="">Product</a></li>
                    <li><a href="">About</a></li>
                    <li><a href="">Contact</a></li>
                    
                </ul>

                
                <i class="fa-solid fa-cart-shopping fa-lg " style="color: white; position: relative;left: 1699px;top: -159px;"></i>
                <a href="addtoCart.html"  style="text-decoration: none;"><p style="color: white;
                    position: relative;
                    left: 1696px;
                    top: -186px;
                    font-size: 16px;
                    font-family: sans-serif;
                    width: 34px;
                    padding-top: 30px;
                    text-decoration: none;">Cart</p></a>
                
                <i class="fa-solid fa-user fa-lg dropbtn" style="color: #ffffff;position: relative;left: 1768px; top: -278px;"></i>
                <div class="dropdown">
                    <button class="dropbtn">Profile</button>
                    <div class="dropdown-content">
                      <a href="reg.html">Orders</a>
                      <a href="reg.html">Wishlist</a>
                      <a href="seller_reg.html">Contact Us</a>
                    </div>
                </div>
            </nav>
        </div> 
        
<sql:query dataSource="${db}" var="rs">  
SELECT * from product;  
</sql:query>  

    <div class="mainbox">
    <h1 class="heading">Our Products</h1>
    <div class="row">
        <c:forEach var="table" items="${rs.rows}" varStatus="loop">
            <div class="col-3">
                <div class="card1">
                    <div class="img-card">
                        <a href=""><img src="<c:out value="${table.image}" />" alt="image"></a>
                    </div>
                    <div class="title-card">
                        <a href="" style="text-decoration: none; color: black; ">
                            <c:out value="${table.prod_name}" />-<c:out value="${table.model_no}" />
                        </a>
                    </div>
                    <div class="rating-card">
                        <button>4.3<i class="fa-sharp fa-solid fa-star fa-xs" style="padding-left: 4px;"></i></button>
                        <h6>(820)</h6>
                    </div>
                    <div class="price-card">
                        <h4>₹<c:out value="${table.price}" /> &nbsp; <s>₹49,990</s> </h4>
                        <h5>14% off</h5>
                    </div>
                    <div class="cart-container">
                        <button id="addToCartButton" onclick="addToCart()">Add to Cart</button>
                        <div id="cartSection" class="hidden">
                            <button onclick="decrement()" class="cart-button">-</button>
                            <input type="number" id="cartCount" class="cart-input" value="1" readonly>
                            <button onclick="increment()" class="cart-button">+</button>
                        </div>
                    </div>
                </div>
            </div>
           
        </c:forEach>
    </div>
</div>
     
                 	
             
                <div class="second-box">
                
            	</div>

            <!-- footer section -->
            
            <div class="footer-area">
                <div class="containers">
                    <div class="rows">
                        <div class="col-lg-3 col-md-6">
                            <div class="footer-box about-widget">
                                <h2 class="widget-title">About us</h2>
                                <p>If you would like to experience the best of online shopping of Laptops in India, you are at the right place. You can shop online at Acsia Laptops from the comfort of your home and get your favourites delivered right to your doorstep.</p>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6">
                            <div class="footer-box get-in-touch">
                                <h2 class="widget-title">Get in Touch</h2>
                                <ul>
                                    <li>HTGRA-16A,HilltopGarden,vazhayila</li>
                                    <li>Contact@ascialaptops.com</li>
                                    <li>+91 7356081201</li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6">
                            <div class="footer-box pages">
                                <h2 class="widget-title">Pages</h2>
                                <ul>
                                    <li><a href="dashboard.html">Home</a></li>
                                    <li><a href="">About</a></li>
                                    <li><a href="">Shop</a></li>
                                    <li><a href="">News</a></li>
                                    <li><a href="">Contact</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6">
                            <div class="footer-box subscribe">
                                <h2 class="widget-title">Subscribe</h2>
                                <p>Subscribe to our mailing list to get the latest updates.</p>
                                <form action="">
                                    <input type="email" placeholder="Email">
                                    <button type="submit"><i class="fas fa-paper-plane"></i></button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="copyright">
                <div class="containers">
                    <div class="rows">
                        <div class="col-lg-6 col-md-12">
                            <p>Copyrights &copy; 2023 - <a href="">Acsia Laptops</a>,  All Rights Reserved.</p>
                        </div>
                        <div class="col-lg-6 text-right col-md-12" style="position: relative; left: 1069px;">
                            <div class="social-icons">
                                <ul>
                                    <li><a href="#" target="_blank"><i class="fab fa-facebook-f"></i></a></li>
                                    <li><a href="#" target="_blank"><i class="fab fa-twitter"></i></a></li>
                                    <li><a href="#" target="_blank"><i class="fab fa-instagram"></i></a></li>
                                    <li><a href="#" target="_blank"><i class="fab fa-linkedin"></i></a></li>
                                    
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
          
        </div>
    </div>
       
</body>
</html>