import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import "./App.css";
import Flashcard from "./components/Flashcards";
import Routes from "./routes/routes";

export interface Card {
  question: string;
  answer: string;
}

function App() {
  return (
    <>
      <Routes />
    </>
  );
}

export default App;
