class ApplyComponent extends React.Component {
constructor(props) {
    	    super(props);
		this.state={}
		
    }

cancel(){
location.href=reactBaseUrl;
}

save(){
	var name=$("#name").val();
	var email=$("#email").val();
	var mobile=$("#mobile").val();
	var agreeTerms=$("#agreeTerms").is(':checked');
	var params={name:name,email:email,mobile:mobile,agreeTerms:agreeTerms,jobId:this.props.jobId};
	var that = this;
	var url = reactBaseUrl + 'apply/job'
	console.log(params);
	$.post( url,params,function( data ) {
		if(data.success){
			$("#myModal").modal('show');
		}else{
			alert("Failed! Please try again.");
		}
	});
}

close(){
	location.href=reactBaseUrl;
}

render(){
    	return(
    			<div className="row">
    				<div className="col-md-12">
    				  <div className="row m-t-20">
    				    <div className="col-md-3">
    				      Name
    				    </div>
    				    <div className="col-md-3">
    				      <input type="text" className="form-control" id="name" placeholder="Name" />
    				    </div>
    				  </div>
    				  <div className="row m-t-20">
  				    <div className="col-md-3">
  				      Mobile
  				    </div>
  				    <div className="col-md-3">
  				      <input type="text"  className="form-control" id="mobile" placeholder="Mobile" />
  				    </div>
  				  </div>
  				<div className="row m-t-20">
			    <div className="col-md-3">
			      Email
			    </div>
			    <div className="col-md-3">
			      <input type="text" className="form-control" id="email" placeholder="Email" />
			    </div>
			  </div>
			  <div className="row m-t-20">
			    <div className="col-md-3">
			      Resume
			    </div>
			    <div className="col-md-3">
			      <input type="file" id="resume"/>
			    </div>
			  </div>
			  
			  <div className="row m-t-20">
			    <div className="col-md-12">
			    <input type="checkbox" id="agreeTerms" /> I agree to all Terms & Conditions.
			    </div>
			    </div>
    				</div>
    				<div className="row m-t-20">
    				<div className="col-md-12">
    				 <button className="btn btn-default" onClick={this.cancel.bind(this)} style={{marginRight:'10px',border:'1px solid grey'}}>Cancel</button>
    			     <button className="btn btn-primary" onClick={this.save.bind(this)}>Apply</button>
    			     </div>
        		   </div>
        		   <div id="myModal" className="modal fade" role="dialog">
        		   <div className="modal-dialog">
        		     <div className="modal-content">
        		       <div className="modal-header">
        		       <h4 className="modal-title">Confirmation of Application</h4>
        		         <button type="button" className="close" data-dismiss="modal">&times;</button>
        		        
        		       </div>
        		       <div className="modal-body">
        		         <p>Thanks for applying for {this.props.technology} Job on {this.props.companyName}</p> 
        		       </div>
        		       <div className="modal-footer">
        		         <button type="button" className="btn btn-default" data-dismiss="modal" onClick={this.close.bind(this)}>Close</button>
        		       </div>
        		     </div>

        		   </div>
        		 </div>
			</div>
		)
	
}

}