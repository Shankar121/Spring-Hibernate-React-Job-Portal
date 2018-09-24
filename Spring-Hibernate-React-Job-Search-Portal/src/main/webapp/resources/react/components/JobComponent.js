class JobComponent extends React.Component {
constructor(props) {
    	    super(props);
		this.state={jobDetails:[],applyShow:false,jobId:-1,technology:'',companyName:''}
		
    }

applyJob(job,e){
	var id=e.target.id;
	var jobId=id.split("_")[1];
	this.setState({applyShow:true,jobId:jobId,technology:job.technology,companyName:'Letsventure'});
	$("#filterContent").hide();
}

render(){
    	return(
    			<div>
    			{this.state.applyShow ?
    					<ApplyComponent jobId={this.state.jobId} technology={this.state.technology} companyName={this.state.companyName} />
			:
				<div>
    			{this.props.data.map((job,i)=>
			    <div key={i} className="job-details">
			      <div className="company-logo"><img src="http://i1.sndcdn.com/avatars-000392078985-f4q8tr-original.jpg"/></div>
			      <div className="job-description">
			      	<div className="job-name">{job.technology}</div>
			      	<ul className="job-highlights">
			      	{job.companydetails ?
			      	<li>{job.companydetails.companyName}</li>
			      	:<li>Letsventure</li>}
			      	<li>{job.jobLocation}</li>
			      	<li>{job.yoeLower}-{job.yoeUpper} yrs of exp</li>
			      	</ul>
			      	<ul className="job-skills">
			      	<li>Skills: </li>
			      	{job.skills.map((skill,i)=>
			      		<li key={10*i}>{skill.name}</li>
			      	)}
			      	</ul>
			      	<button className="btn btn-mini btn-primary apply-btn m-t-10"  companyName={"Letsventure"} id={"job_"+job.id} onClick={this.applyJob.bind(this,job)}>Apply</button>
			      </div>
			    </div>
			)}
			</div>
    			}	
    			</div>
		)
	
}

}