import React from 'react';
import { graphql } from 'react-apollo';
import { compose, branch, renderComponent } from 'recompose';

import { MyQuery } from './queries.graphql'

const Main = props => { console.log('p', props); return (
    <div>
        {props.data.me.extra}
    </div>
)};

const loading = () => <span>Loading</span>;

export default compose(
    graphql(MyQuery),
    branch(({ data: { loading } }) => loading, renderComponent(loading))
)(Main);
