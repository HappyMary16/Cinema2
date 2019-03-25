import React, {Component} from 'react';
import axios from 'axios';

import AdminMenu from "../AdminMenu";
import '../../../style/DataList.css'
import '../../../style/DataForm.css'

class HallCard extends Component {
    constructor(props) {
        super(props);

        this.state = {
            hall: {
                name: '',
                width: '',
                height: '',
                placement: []
            },
            id: new URLSearchParams(this.props.location.search).get("id")
        }
    }

    componentWillMount() {
        const GET_ALL_URL = "http://localhost:8080/halls/" + this.state.id;
        axios.get(GET_ALL_URL)
            .then(response => {
                this.setState({hall: response.data});
            });
    }

    componentWillReceiveProps(nextProps) {
        const GET_ALL_URL = "http://localhost:8080/halls/" + this.state.id;
        axios.get(GET_ALL_URL)
            .then(response => {
                this.setState({hall: response.data});
            })
    }

    createHallPlacement() {
        let row = [];
        debugger;

        const arr = [
            {
                name: 'Anton',
                isStudent: false
            },
            {
                name: 'Maria',
                isStudent: true
            },
        ];

        {/*<table>*/
        }
        {/*{*/
        }
        {/*arr.map((item) => (*/
        }
        {/*<tr>*/
        }
        {/*item.map*/
        }
        {/*</tr>*/
        }
        {/*))*/
        }
        {/*}*/
        }
        {/*</table>*/
        }
        return (
            <table>
                {/*{*/}
                    {/*this.state.hall.placement.map((item) => (*/}
                    {/*item.map((isPlace) => ())*/}

                    {/*))*/}
                {/*}*/}
                {/*item.map((isPlace) => (*/}
                {/*if (isPlace) {*/}
                {/*<td><input type='button'/></td>*/}
            {/*} else {*/}
                {/*<td><p></p></td>*/}
            {/*}*/}
                {/*))*/}


            </table>
        )
    }

    render() {
        return (
            <div className="wrapper">
                <AdminMenu/>

                <div className="allUsers" id="content">
                    <p><label htmlFor="name">Name:</label>
                        <input type="text" name="name" id="name" value={this.state.hall.name} readOnly/>
                    </p>
                    <p><label htmlFor="width">Width:</label>
                        <input type="number" name="width" id="width" value={this.state.hall.width} readOnly/></p>
                    <p><label htmlFor="height">Number rows:</label>
                        <input type="number" name="height" id="height" value={this.state.hall.height} readOnly/></p>
                    {/*<p><label htmlFor="numberPlaces">Number places:</label>*/}
                    {/*<input type="text" name="numberPlaces" id="numberPlaces"*/}
                    {/*value={this.state.hall.places.length} readOnly/></p>*/}

                    {this.createHallPlacement()}

                    <p>
                        <a href={"/add_placement?id=" + this.state.id}>Add placement</a>
                    </p>
                    <p>
                        <a href={"/hall_update?id=" + this.state.id}>Update</a>
                    </p>
                </div>
            </div>
        );
    }
}

export default HallCard;