import { Flex } from "@mantine/core";
import TypeMessage from "./TypeMessage.jsx";
import MessageArea from "./MessageArea.jsx";
function MessageDisplay() {
  return (
    <>
      <Flex
        h="100%"
        mah="100%"
        w="85%"
        direction="column"
        py="10px"
        px="20px"
        justify="space-between"
      >
        <MessageArea />
        <TypeMessage />
      </Flex>
    </>
  );
}

export default MessageDisplay;
