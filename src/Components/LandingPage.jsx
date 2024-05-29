import { Link } from "react-router-dom";
import '../Styles/LandingPage.css'
const LandingPage = () => {
    return ( 
        <div className="landingpage">
            <Link to="/adminlogin"> 
              <img src="https://t4.ftcdn.net/jpg/02/27/45/09/360_F_227450952_KQCMShHPOPebUXklULsKsROk5AvN6H1H.jpg" alt="" />
              <h2>Admin</h2>
            </Link>
            <Link to="/userlogin"> 
              <img src="https://www.iconpacks.net/icons/1/free-user-login-icon-305-thumb.png" alt="" />
              <h2>User</h2>
            </Link>

        </div> 

    );
}
 
export default LandingPage;