class App extends React.Component {
constructor(props) {
    	    super(props);
		this.state={}
    }

componentDidUpdate(){
	
}

render(){
  
    	return(
			<div>
			   <Header />
			   <Content />
			   <Footer />
			</div>
		)
	
}

}

class Content extends React.Component {
	constructor(props) {
	    	    super(props);
			this.state={}
	    }

	componentDidUpdate(){
		
	}

	render(){
	  
	    	return(
				<div className="content" id="content">
				       <AppComponent/>
				</div>
			)
		
	}

}

class Header extends React.Component {
	constructor(props) {
	    	    super(props);
			this.state={}
	    }

	componentDidUpdate(){
		
	}

	render(){
	  
	    	return(
				<div  className="header">
				       <img src="http://blog.letsventure.com/wp-content/uploads/2017/02/xyz.png" height="50px"/>
				    	   <span className="login-info">Sign In</span>
				</div>
			)
		
	}

}

class Footer extends React.Component {
	constructor(props) {
	    	    super(props);
			this.state={}
	    }

	componentDidUpdate(){
		
	}

	render(){
	  
	    	return(
				<div  className="footer">
				  <span>&#169; </span>Copyright Protected, 2018 | XYZ
				  <span className="footer-list">Terms | Contact us</span>
				</div>
			)
		
	}

}