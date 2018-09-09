import React, { Component } from 'react';
import axios from 'axios';

const TableCor = (props) => {
    return (
        <div>
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nome</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    {props.dados.map(cor => {
                        return (
                            <tr key={cor.id}>
                                <td>{cor.id}</td>
                                <td>{cor.nome}</td>
                                <td><button onClick={() => props.excluir(cor.id)}>Excluir</button></td>
                            </tr>
                        );
                    })}
                </tbody>
            </table>
        </div>
    );
}

class ListCor extends Component {
    constructor(props) {
        super(props);
        this.state = {
            cores: []
        };
        this.obterCores();
    }
    obterCores() {
        axios.get('http://localhost:8080/api/cores')
            .then(({ data }) => {
                this.setState({ ...this.state, cores: data });
            })
            .catch((error) => {
                //console.log(error);
                this.setState({ ...this.state, cores: [] });
            });

    }
    excluir(id) {
        axios.delete(`http://localhost:8080/api/cores/${id}`)
            .then(() => this.obterCores())
            .catch((error) => {
                console.log(error);
            });
    }
    render() {
        if (this.state.cores.length === 0) {
            return <div>Sem cores para exibir...</div>;
        }
        return (
            <div>cores <TableCor dados={this.state.cores} excluir={(id) => this.excluir(id)}></TableCor></div>
        );

    }
};

export default ListCor;