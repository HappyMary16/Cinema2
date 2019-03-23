import React, {Component} from 'react';
import axios from 'axios';
import AdminMenu from "../../../AdminMenu";

import '../../../../../style/FilmData.css';

class ActorList extends Component {
    constructor(props) {
        super(props);

        this.state = {
            actors: []
        }
    }

    componentWillMount() {
        const GET_ALL_URL = "http://localhost:8080/persons/all_actors";
        axios.get(GET_ALL_URL)
            .then(response => {
                this.setState({actors: response.data});
            })
    }

    componentWillReceiveProps(nextProps) {
        const GET_ALL_URL = "http://localhost:8080/persons/all_actors";
        axios.get(GET_ALL_URL)
            .then(response => {
                this.setState({actors: response.data});
            })
    }

    onClickHandler = () => {
        this.props.history.push("/add_person")
    };

    render() {
        return (
            <div className="wrapper">
                <AdminMenu/>
                <div className="allActor" id="content">

                    <p>
                        <button onClick={this.onClickHandler}>Add actor</button>
                    </p>

                    <h1>Actors</h1>
                    <table>
                        <tr>
                            <th className="title">№</th>
                            <th className="title">First name</th>
                            <th className="title">Last name</th>
                        </tr>
                        {this.state.actors.map(function (d, idx) {
                            return (
                                <tr key={idx}>
                                    <td>{idx + 1}</td>
                                    <td>{d.firstName}</td>
                                    <td>{d.lastName}</td>
                                </tr>
                            )
                        })}
                    </table>

                </div>
            </div>
        );
    }
}

export default ActorList;