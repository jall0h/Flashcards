import { createBrowserRouter, RouterProvider } from "react-router-dom";
import FlashcardView from "../pages/FlashcardView";
import DeckCreation from "../pages/DeckCreation";

const Routes = () => {
  const router = createBrowserRouter([
    {
      path: "/",
      element: <FlashcardView />,
    },
    {
      path: "/createdeck",
      element: <DeckCreation />,
    },
  ]);

  return <RouterProvider router={router} />;
};

export default Routes;
