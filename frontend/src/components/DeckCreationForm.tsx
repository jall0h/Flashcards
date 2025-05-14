import { useRef } from "react";
import type { Card } from "../App";

interface Props {
  deck: Card[];
}
const DeckCreationForm = ({ deck }: Props) => {
  const question = useRef<HTMLInputElement>(null);
  const answer = useRef<HTMLInputElement>(null);

  const addToDeck = (card: Card, deck: Card[]) => {
    deck.push(card);
  };

  const addCard = (question: string, answer: string) => {
    const newCard: Card = { question: question, answer: answer };
    addToDeck(newCard, deck);
    console.log(deck);
  };

  const clearInput = () => {
    const inputs: HTMLCollectionOf<HTMLInputElement> =
      document.getElementsByClassName(
        "flashcard-input"
      ) as HTMLCollectionOf<HTMLInputElement>;
    for (let x of inputs) {
      x.value = "";
    }
  };
  return (
    <>
      <h1>Form</h1>
      <form
        onSubmit={(event) => {
          event.preventDefault();
          if (question.current && answer.current) {
            addCard(question.current?.value, answer.current?.value);
            clearInput();
          }
        }}
      >
        <div>
          <label>Question</label>
          <input className="flashcard-input" ref={question} type="text"></input>
        </div>
        <div>
          <label>Answer</label>
          <input className="flashcard-input" ref={answer} type="text"></input>
        </div>
        <button type="submit">Add Card</button>
      </form>
    </>
  );
};

export default DeckCreationForm;
