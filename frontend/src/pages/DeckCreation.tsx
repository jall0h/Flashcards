import type { Card } from "../App";
import DeckCreationForm from "../components/DeckCreationForm";

const DeckCreation = () => {
  const qList: Card[] = [
    { question: "what is my name?", answer: "abu" },
    { question: "what is my other name?", answer: "nextabu" },
  ];
  return (
    <>
      <h1>Create a deck</h1>
      <DeckCreationForm deck={qList} />
    </>
  );
};

export default DeckCreation;
