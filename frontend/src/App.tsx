import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import "./App.css";
import Flashcard from "./components/Flashcards";

export interface Card {
  question: string;
  answer: string;
}

function App() {
  const qList: Card[] = [
    { question: "what is my name?", answer: "abu" },
    { question: "what is my other name?", answer: "nextabu" },
  ];
  return (
    <>
      <Flashcard deck={qList} />
    </>
  );
}

export default App;
