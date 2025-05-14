import type { Card } from "../App";
import DeckCreationForm from "../components/DeckCreationForm";
import Flashcard from "../components/Flashcards";

const FlashcardView = () => {
  const qList: Card[] = [
    { question: "what is my name?", answer: "abu" },
    { question: "what is my other name?", answer: "nextabu" },
  ];
  return (
    <>
      <h1>Flashcards</h1>
      <DeckCreationForm deck={qList} />
      <Flashcard deck={qList} />
    </>
  );
};

export default FlashcardView;
