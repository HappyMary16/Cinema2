import React, {Component} from 'react';
import axios from 'axios';

import AdminMenu from "../AdminMenu";
import '../../../style/DataList.css'
import '../../../style/DataForm.css'

class AdminList extends Component {
    constructor(props) {
        super(props);

        this.state = {
            halls: []
        }
    }

    componentWillMount() {
        const GET_ALL_URL = "http://localhost:8080/halls/all";
        axios.get(GET_ALL_URL)
            .then(response => {
                this.setState({halls: response.data});
            })
    }

    componentWillReceiveProps(nextProps) {
        const GET_ALL_URL = "http://localhost:8080/halls/all";
        axios.get(GET_ALL_URL)
            .then(response => {
                this.setState({halls: response.data});
            })
    }

    onClickHandler = () => {
        this.props.history.push("/add_hall")
    };

    render() {
        return (
            <div className="wrapper">
                <AdminMenu/>
                <div className="allHalls" id="content">
                    <h1>Halls</h1>
                    <table>
                        <tr>
                            <th className="title">№</th>
                            <th className="title">Name</th>
                            <th className="title">Width</th>
                            <th className="title">Number row</th>
                            <th className="title">Number place</th>
                        </tr>
                        {this.state.halls.map(function (d, idx) {
                            return (
                                <tr key={idx}>
                                    <a href={"hall_card?id=" + d.id}>
                                        <td>{idx + 1}</td>
                                    </a>
                                    <td>{d.name}</td>
                                    <td>{d.width}</td>
                                    <td>{d.height}</td>
                                    <td>{d.places.length}</td>
                                </tr>
                            )
                        })}
                    </table>

                    <p>
                        <button onClick={this.onClickHandler}>Add hall</button>
                    </p>
                </div>
            </div>
        );
    }
}

export default AdminList;