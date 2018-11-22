import React from 'react';
import ApolloClient from "apollo-boost";
import { ApolloProvider } from "react-apollo";
import Main from './components/main';

const client = new ApolloClient({
    uri: "http://localhost:5000/graphql"
});

export default () => (
    <ApolloProvider client={client}>
        <Main />
    </ApolloProvider>
);
