import { Flex } from "@mantine/core";
import Message from "./Message";
const messages = [
  { content: "Hello how are you", senderId: 234 },
  { content: "Hello how are you", senderId: 123 },
  { content: "Hello how are you", senderId: 123 },
  { content: "Hello how are you", senderId: 234 },
];
function MessageArea() {
  return (
    <>
      <Flex flex="1" direction="column" gap="10px">
        {messages.map((message, index) => {
          return <Message key={index} data={message} />;
        })}
      </Flex>
    </>
  );
}

export default MessageArea;
