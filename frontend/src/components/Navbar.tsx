import { Link } from "react-router-dom";
import { CgProfile } from "react-icons/cg";

const Navbar = () => {
  return (
    <nav id="navbar">
      <ul className="navbar-list">
        <li>
          <Link className="navbar-link" to="/">
            Dashboard
          </Link>
        </li>
        <li>
          <Link className="navbar-link" to="/decks">
            My Decks
          </Link>
        </li>
        <li>
          <Link className="navbar-link" to="/createdeck">
            Create a Deck
          </Link>
        </li>
        {/* <li>
          <Link className="navbar-link" to="/signout">
            Sign Out
          </Link>
        </li> */}
      </ul>
    </nav>
  );
};

export default Navbar;
