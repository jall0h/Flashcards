import { useEffect, useState } from "react";
import type { Card } from "../App";

interface Props {
  deck: Card[];
}

const Flashcard = ({ deck }: Props) => {
  const [card, setCard] = useState<Card>(
    deck.length > 0 ? deck[0] : { question: "Question", answer: "Answer" }
  );
  const [finished, setFinished] = useState<Boolean>(false);

  const nextCard = () => {
    const currIndex = deck.indexOf(card);
    if (currIndex + 1 < deck.length) {
      setCard(deck[currIndex + 1]);
    } else {
      setFinished(true);
    }
  };

  const displayAnswer = () => {
    const answer = document.getElementById("answer");
    answer?.classList.add("display");
  };

  const hideAnswer = () => {
    const answer = document.getElementById("answer");
    answer?.classList.remove("display");
  };

  useEffect(() => {
    hideAnswer();
  }, [card]);

  if (finished) {
    return <h1>Deck Finished</h1>;
  }
  return (
    <>
      <p id="question">{card.question}</p>
      <hr />
      <p id="answer">{card.answer}</p>
      <button id="answer-btn" onClick={displayAnswer}>
        Show Answer
      </button>
      <button onClick={nextCard}>Next</button>
    </>
  );
};

export default Flashcard;
