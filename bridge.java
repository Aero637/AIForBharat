// Simplified Controller to trigger Molecular Discovery
@RestController
@RequestMapping("/api/discovery")
public class DiscoveryController {

    @PostMapping("/propose")
    public ResponseEntity<String> triggerAIProposal(@RequestBody ReactionTarget target) {
        // Log target in secure sandbox [cite: 105, 164]
        System.out.println("Initiating discovery for: " + target.getReactionType());
        
        // Execute Python script for GNN modeling [cite: 62, 65]
        try {
            ProcessBuilder pb = new ProcessBuilder("python", "gnn_engine.py", target.getReactionType());
            Process p = pb.start();
            return ResponseEntity.ok("AI Engine triggered. Results will appear on dashboard.");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Orchestration failed.");
        }
    }
}