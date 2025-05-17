import { createBrowserRouter, RouterProvider } from "react-router-dom";
import FlashcardView from "../pages/FlashcardView";
import DeckCreation from "../pages/DeckCreation";
import ProtectedRoute from "./ProtectedRoute";
import Dashboard from "../pages/Dashboard";
import Decks from "../pages/Decks";

const Routes = () => {
  const router = createBrowserRouter([
    {
      element: <ProtectedRoute />,
      children: [
        {
          path: "/viewdeck",
          element: <FlashcardView />,
        },
        {
          path: "/createdeck",
          element: <DeckCreation />,
        },
        {
          path: "/",
          element: <Dashboard />,
        },
        {
          path: "/decks",
          element: <Decks />,
        },
      ],
    },
  ]);

  return <RouterProvider router={router} />;
};

export default Routes;
